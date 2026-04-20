class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        n=len(points)
        points.sort(key=lambda x:x[1])
        c=1
        ap=points[0][1]
        for i in range(n):
            if points[i][0]>ap:
                c+=1
                ap=points[i][1]
        return c