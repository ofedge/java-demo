#!usr/bin/python3
# -*- coding: utf-8 -*-

r'''
insertsort.py

快速插入排序

usage:

python3 insertsort.py
'''


def insertsort(L):
    for i in range(1, len(L)):
        tmp = L[i]
        j = i - 1
        while j >= 0 and (L[j] > tmp):
            L[j + 1] = L[j]
            j -= 1
        L[j + 1] = tmp
    return L        
        


if __name__ == '__main__':
    L = [4,3,6,9,7,1,2,4]
    print(insertsort(L))
