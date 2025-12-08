class Solution:
    def countTriples(self, n: int) -> int:
        cnt = 0
        for a in range(1, n):
            for b in range(a + 1, n):
                c_squared = a * a + b * b
                c = int(c_squared ** 0.5)
                if c * c == c_squared and c <= n:
                    cnt += 2
        return cnt