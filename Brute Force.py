#to brute force a zip file
import zipfile

charlist='abcdeffghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+='
complete=[]

for current in range(4):  #the number in range is to denote the number to characters in the password
    #the shorter the range the less time required to crack
    a=[i for i in charlist]
    for x in range(current):
        a=[y+i for i in charlist for y in a]
    complete= complete + a

z=zipfile.ZipFile('Exercise_2.zip')
t=0

for password in complete:
    try:
        t+=1
        z.setpassword(password.encode('ascii'))
        z.extract('test.txt')
        print(f'password was found after {t} tries! The password is {password}')
    except:
        pass
