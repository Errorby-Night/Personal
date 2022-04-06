from __future__ import print_function
import cv2
import numpy as np
import argparse

gamma = 1.0
def gamma_ad(image, gamma):
    invgam = 1.0/gamma
    table = np.array([((i/255.0) ** invgam)*255 for i in np.arange(0, 256)]).astype('uint8')
    return cv2.LUT(image, table)

def isbright(image, dim, thresh):
    image = cv2.resize(image, (dim, dim))
    L, A, B = cv2.split(cv2.cvtColor(image, cv2.COLOR_BGR2LAB))
    L = L/np.max(L)
    return (np.mean(L)> thresh)

vid = cv2.VideoCapture("light_test_data/im (%d).jpg") #file path
output = cv2.VideoWriter("result2.mp4", cv2.VideoWriter_fourcc(*'MP4V'), 24.0, (720, 480))
if (vid.isOpened() == False):
    print("ERROR")
else:
    while(vid.isOpened()):
        ret, frame = vid.read()
        if ret == True:
            a = isbright(frame, 15, 0.5)
            if(a):
                gamma = 1.0
            else:
                gamma = 2.0
            adjust = gamma_ad(frame, gamma)
            print(gamma)
            i2 = cv2.resize(adjust , (720, 480), interpolation = cv2.INTER_LINEAR)
            i3 = cv2.resize(frame , (720, 480), interpolation = cv2.INTER_LINEAR)
            cv2.imshow('ORG', i3)
            cv2.imshow('Frames', i2)
            output.write(adjust)
            cv2.waitKey(50)
vid.release()
cv2.destroyAllWindows()
