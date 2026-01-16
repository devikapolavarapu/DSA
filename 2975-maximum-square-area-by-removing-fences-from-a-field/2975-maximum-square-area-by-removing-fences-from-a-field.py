class Solution:
    def maximizeSquareArea(self, m: int, n: int, hFences: List[int], vFences: List[int]) -> int:
        mod = 10**9 + 7
        hFences.extend([1,m])
        vFences.extend([1,n])
        hFences.sort()
        vFences.sort()
        possible_heights = set()
        possible_widths = set()
        for i in range(len(hFences)):
            for j in range(i + 1, len(hFences)):
                possible_heights.add(hFences[j] - hFences[i])
        max_area = 0
        for i in range(len(vFences)):
            for j in range(len(vFences) - 1, i, -1):
                width = vFences[j] - vFences[i]
                if width in possible_heights:
                    max_area = max(max_area, width * width)
                    break
        return max_area % mod if max_area > 0 else -1