import csv
import functools
import sys

from sortedcontainers import SortedSet, SortedList

TOTAL_TAG = '$total'
ListType = SortedList


@functools.total_ordering
class Node:
    parent = None
    children = ListType()
    tag = 'root'
    values = []

    def __init__(self, children=ListType(), tag=None, values=None):
        self.children = children
        if tag is not None:
            self.tag = tag
        if values is not None:
            self.values = values

    def __str__(self):
        return self.tag

    def __eq__(self, other):
        return self.tag == other.tag

    def __lt__(self, other):
        return self.tag < other.tag

    def add(self, other):
        if other in self.children:

            # Recursion over children
            curr = self.children[self.children.index(other)]
            for c in other.children:
                curr.add(c)

        else:

            # Merge children
            other.parent = self
            self.children.add(other)

            # Sum values in parent
            for i in range(0, len(other.values)):
                if self.values is None:
                    self.values = [0] * len(other.values)
                self.values[i] += other.values[i]

    @property
    def is_leaf(self):
        return len(self.children) == 0

    @property
    def parents(self):
        ancestors = []
        curr = self.parent
        while curr is not None:
            ancestors += curr
        return ancestors

    @property
    def leafs(self):
        if self.is_leaf:
            return ListType([self])
        else:
            children = ListType()
            for child in self.children:
                children += child.leafs
            return children

    @staticmethod
    def from_hierarchy(hierarchy):
        node = None
        root = None
        for prop in hierarchy:
            if prop.isnumeric():
                node.values.append(prop)
                continue
            new_node = Node(tag=prop)
            if node is None:
                node = new_node
                root = node
            else:
                node.children.add(new_node)
                node = new_node
        return root


if __name__ == "__main__":

    # Read input
    f = sys.stdin.read().splitlines()
    csv = csv.reader(f, delimiter='|')

    # Populate tree
    tree = Node()
    is_first = True
    for row in list(csv):
        if is_first:
            is_first = False
            continue
        if TOTAL_TAG in row:
            continue
        h = Node.from_hierarchy(row)
        tree.add(h)

    # Show tree
    leafs = tree.leafs
    for node in leafs:
        str = ''
        parents = node.parents
        for p in parents:
            str += p.tag + '|'
        print(str)

