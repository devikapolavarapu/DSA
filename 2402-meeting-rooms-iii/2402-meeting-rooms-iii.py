class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        if n == 1:
            return 0
        ends = [0] * n
        counts = [[i, 0] for i in range(n)]
        meetings.sort()
        t = 0
        while meetings:
            if meetings[0][0] <= t:
                for i, e in enumerate(ends):
                    if t >= e:
                        s, e = meetings.pop(0)
                        ends[i] = t + e - s
                        counts[i][1] += 1
                        break
            else:
                t += 1
                continue
            t = min(ends)

        return max(counts, key = lambda x: x[1])[0]