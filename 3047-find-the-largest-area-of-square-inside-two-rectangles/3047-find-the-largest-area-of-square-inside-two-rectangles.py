class Solution:
    def largestSquareArea(self, bottomLeft: List[List[int]], topRight: List[List[int]]) -> int:
        maximal_size = 0 
        for i in range(len(bottomLeft)): 
            x10, y10 = bottomLeft[i]
            x11, y11 = topRight[i]
            if y11-y10<=maximal_size or x11-x10<=maximal_size: 
                continue
            for j in range(i+1, len(bottomLeft)): 
                x20, y20 = bottomLeft[j]
                x21, y21 = topRight[j]
                if y21-y20<=maximal_size or x21-x20<=maximal_size: 
                    continue
                if x21 <= x10 or y21<=y10 or x20>=x11 or y20>=y11: 
                    continue 
                size_x_intersect = min(x11, x21) - max(x10, x20)
                if size_x_intersect < maximal_size: 
                    continue 
                size_y_intersect = min(y11, y21) - max(y10, y20)
                if size_y_intersect < maximal_size:
                    continue 
                maximal_size = min(size_x_intersect, size_y_intersect)
        return maximal_size**2