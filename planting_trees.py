#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'plantingTrees' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER m
#  2. INTEGER n
#  3. STRING_ARRAY matrix
#

def plantingTrees(m, n, matrix):
    trees = 0
    for i in range(1, m - 1):
        for j in range(1, n - 1):
            if not "P" in [matrix[k][l] for k in range(i - 1, i + 2) for l in range(j - 1, j + 2)]:
                trees += 1

    return trees

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    m = int(input().strip())

    n = int(input().strip())

    matrix = []

    for _ in range(m):
        matrix_item = input()
        matrix.append(matrix_item)

    answer = plantingTrees(m, n, matrix)

    fptr.write(str(answer) + '\n')

    fptr.close()
