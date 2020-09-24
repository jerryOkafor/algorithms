"""
Asked by SnapChat from the Daily Coding Problem:

Given a list of possible overlapping intervals, return a new list of intervals
where all overlapping intervals have been merged

The input list is not necessarily ordered in any way.
For example:
Input: [(1, 3), (5, 8), (4, 10), (20, 25)]]
Output: [(1, 3), (4, 10), (20, 25)].

We can do this by sorting the intervals by their start time. This way, looking
when looking at the current interval, if it overlaps with the previous one, we can just combine them

Note: Since we have to sort the list, this runs in O(n log n)
"""

def overlappingIntervals(intervals):
    result = []

    for start, end in sorted(intervals, key=lambda i: i[0]):  # [(1, 3), (4, 10), (5, 8), (20, 5)]

        # if current interval overlaps with the previous one, combine them
        # they overlap id the end of current is <= start of previous
        if result and start <= result[-1][1]:  # currentStart <= preEnd

            prev_start, prev_end = result[-1]
            result[-1] = (prev_start, max(end, prev_end))
        else:
            result.append((start, end))
    return result


print(overlappingIntervals([(1, 3), (20, 5), (4, 10), (5, 8)]))
