#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'inefficientCampusDirections' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. STRING directions
#

def inefficientCampusDirections(n, directions):
    x, y = 0, 0
    for d in directions:
        if d == "N":
            y += 1
        elif d == "S":
            y -= 1
        elif d == "E":
            x += 1
        elif d == "W":
            x -= 1
    
    return abs(x) + abs(y)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    directions = input()

    answer = inefficientCampusDirections(n, directions)

    fptr.write(str(answer) + '\n')

    fptr.close()
