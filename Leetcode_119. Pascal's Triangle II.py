'''
119. Pascal's Triangle II

Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
'''


class Solution:
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        arrList = []
        for i in range(rowIndex + 1):
            if i == 0:
                arrList = [1]
            elif i == 1:
                arrList = [1, 1]
            else:
                temp = [1]
                for j in range(1, i):
                    temp.append(arrList[j - 1] + arrList[j])
                temp.append(1)
                arrList = temp
        return arrList
