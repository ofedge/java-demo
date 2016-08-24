#!usr/bin/python3
# -*- coding: utf-8 -*-

r'''
heapsort.py

堆排序

usage:

python3 heapsort.py
'''

def heapsort(L, lastIndex):
    if lastIndex is 0:
        return
    lp = lastIndex
    for i in range((lastIndex-1)>>1, -1, -1):
        k = i
        while (k << 1) + 1 <= lastIndex:
            biggerIndex = (k << 1) + 1
            if biggerIndex < lastIndex:
                if L[biggerIndex] < L[biggerIndex + 1]:
                    biggerIndex = biggerIndex + 1
            if L[k] < L[biggerIndex]:
                L[k], L[biggerIndex] = L[biggerIndex], L[k]
                break
            else:
                break
    L[0], L[lp] = L[lp], L[0]
    heapsort(L, lastIndex-1)
    

        
if __name__ == '__main__':
    L = [4,3,6,9,7,1,2,4]
    heapsort(L, 7)
    print(L)
        
