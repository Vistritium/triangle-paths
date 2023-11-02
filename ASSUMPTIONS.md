### Assumptions

* Input is formatted correctly, as described in specification. Plus extra additional empty line in the end is expected to finish providing the input.
* Input values are integers that fit the standard range ( -2147483648 to 2147483647 )

### Implementation

In the end I used simple scala project with no additional libraries. The solution is written using tail recursive function that starts with bottom nodes and calculates current minimal path for each node, by selecting only the smaller value between node's two children.

