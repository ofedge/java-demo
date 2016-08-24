#!usr/bin/python3
# -*- coding: utf-8 -*-

r'''
quicksort.py

快速排序

usage:

python3 quicksort.py
'''

def quicksort(L, low, high):
    i = low
    j = high
    if i >= j:
        return L
    key = L[i]
    while i < j:
        while i < j and L[j] >= key:
            j = j - 1
        L[i] = L[j]
        while i < j and L[i] <= key:
            i = i + 1
        L[j] = L[i]
    L[i] = key
    quicksort(L, low, i - 1)
    quicksort(L, j + 1, high)
    return L


if __name__ == '__main__':
    L = [4,3,6,9,7,1,2,4]
    print(quicksort(L, 0, len(L)-1))
