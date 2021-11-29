import pyautogui, time

time.sleep(6)
f=open("<file name>.txt",'r')
for word in f:
    pyautogui.typewrite(word)
    pyautogui.press("enter")
