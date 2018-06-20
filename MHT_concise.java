class Solution(object):
    def findMinHeightTrees(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        if n == 1: return [0]


        graph = [set() for _ in xrange(n)]
        for i,j in edges:
            graph[i].add(j)
            graph[j].add(i)

        # the intuition is that in a connected graph,
        # if you pick a node of degree 1 as the root
        # then the resulting tree has the max ht.
        # so trim the leaves until there are at most 2
        # and at least 1 node left.

        leaves = [i for i in xrange(n) if len(graph[i]) == 1]
        while n > 2:
            n -= len(leaves)
            new_leaves = []
            for leaf in leaves:
                neighbor = graph[leaf].pop()
                graph[neighbor].remove(leaf)
                if len(graph[neighbor]) == 1: new_leaves.append(neighbor)

            leaves = new_leaves

        return leaves
