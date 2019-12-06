#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'lazyGrading' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. STRING_ARRAY frq
#

def check(str):
    stack = []
    for i in str:
        if(i == ")"):
            if not stack[-1] == ")":
                return False
            stack.pop()
        elif(i == "]"):
            if not stack[-1] == "]":
                return False
            stack.pop()
        elif(i == "}"):
            if not stack[-1] == "}":
                return False
            stack.pop()
        elif(i == "("):
            stack.append(")")
        elif(i == "["):
            stack.append("]")
        elif(i == "{"):
            stack.append("}")
    return len(stack) == 0

def lazyGrading(n, frq):
    if(check("".join(frq))):
        return 1
    else:
        return 0

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    frq = []

    for _ in range(n):
        frq_item = input()
        frq.append(frq_item)

    answer = lazyGrading(n, frq)

    fptr.write(str(answer) + '\n')

    fptr.close()
