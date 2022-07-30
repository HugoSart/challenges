import csv
import functools
import sys

from sortedcontainers import SortedSet, SortedList

TOTAL_TAG = '$total'
ListType = SortedList


@functools.total_ordering
class Row:
    tags = []
    values = []

    def __init__(self, tags=None, values=None):
        if values is None:
            self.values = []
        if tags is None:
            self.tags = []

    def __str__(self):
        return self.tag

    def __eq__(self, other):
        return self.tag == other.tag

    def __lt__(self, other):
        return self.tag < other.tag


if __name__ == "__main__":

    # Read input
    f = sys.stdin.read().splitlines()
    csv = csv.reader(f, delimiter='|')

    # Populate tree
    weights = {}
    for row in list(csv):
        if TOTAL_TAG in row:
            continue
        hierarchy = Node.from_hierarchy(row)
        tree.add(hierarchy)

