"""
Delete a node from a sngle-linked list, given only a variable
pointer to that node.
"""


class LinkedListNode(object):

    def __init__(self, value):
        self.value = value
        self.next = None


a = LinkedListNode("A")
b = LinkedListNode("B")
c = LinkedListNode("C")

a.next = b
b.next = c


def delete_node(node_to_delete):
    # Get the input node's next node, the one we want to skip to
    next_node = node_to_delete.next

    if next_node:
        # Replace the input node's value and pointer with the next
        # next nodes value and pointer. The previous node now effectively
        # skips over the current node
        node_to_delete.value = next_node.value
        node_to_delete.next = next_node.next
    else:
        # Oops, we are trying to delete the last node.
        raise Exception("Can't delete the last node with this technique")


"""
Side Effects:

1. Any references to the input node have now effectively been reassigned to 
its next node. In our example, we "deleted" the node assigned to the variable 
b, but in actuality we just gave it a new value (2) and a new next! If we had 
another pointer to b somewhere else in our code and we were assuming it still 
had its old value (8), that could cause bugs.

2. If there are pointers to the input node's original next node, those pointers now point to 
a "dangling" node (a node that's no longer reachable by walking down our list). In our 
example above, c is now dangling. If we changed c, we'd never encounter that new value by 
walking down our list from the head to the tail.

Lessons:
The solution is imperfect. Given that it modifies the list in place, it can cause other parts
of the surounding ssytem to break - this is called side effect.
In-place operations like this can save time and/or space but they're risky. 
f you ever make in-place modifications in an interview, make sure you tell your 
interviewer that in a real system you'd carefully check for side effects in the rest of the code base.

"""
