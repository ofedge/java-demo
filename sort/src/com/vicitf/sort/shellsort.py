#!usr/bin/python3
# -*- coding: utf-8 -*-

r'''
shellsort.py

希尔排序

usage:

python3 shellsort.py
'''


def shellsort(L):
    gap = len(L) >> 1
    while 1 <= gap:
        for i in range(gap, len(L)):
            temp = L[i]
            j = i - gap
            while j >= 0 and temp < L[j]:
                L[j + gap] = L[j]
                j = j - gap
            L[j + gap] = temp
        gap = gap >> 1
    return L
    


if __name__ == '__main__':
    L = [4,3,6,9,7,1,2,4]
    print(shellsort(L))
