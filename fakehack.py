import time as t
import pyautogui as p

j=10
for i in range(10):
    t.sleep(3)
    j=j*(i+1)
    print("HAcking into main frame... ",j, "%")
    j=j/(i+1)
j=100.0
if j==100.0:
    print("Hacked successfully into mainframe")
