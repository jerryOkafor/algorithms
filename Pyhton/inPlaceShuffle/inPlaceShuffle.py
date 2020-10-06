"""
Write a funtion to do in-place shuffle of a list:

Solution:
If we didn't have the "in-place" requirement, we could allocate a new list,
then one-by-one take a random item from the input list, remove it, put it in the first position
in the new list, and keep going until the input is empty.
"""

import random

"""
This is a semi-famous algorithm known as the Fisher-Yates shuffle (sometimes called the Knuth shuffle).
Complexity: O(n)O(n) time and O(1)O(1) space.

Links: https://medium.com/@oldwestaction/randomness-is-hard-e085decbcbb2
"""


def get_random(floor, ceiling):
    return random.randrange(floor, ceiling + 1)


def shuffle(the_list):
    # If it's 1 or 0 items, just return
    if len(the_list) <= 1:
        return the_list

    last_index_in_the_list = len(the_list) - 1

    # Walk through from beginning to end
    for index_we_are_choosing_for in reversed(range(0, len(the_list) - 1)):

        # Choose a random not-yet-placed item to place there
        # (could also be the item currently in that spot)
        # Must be an item AFTER the current item, because the stuff
        # before has all already been placed
        random_choice_index = get_random(index_we_are_choosing_for,
                                         last_index_in_the_list)

        # Place our random choice in the spot by swapping
        if random_choice_index != index_we_are_choosing_for:
            the_list[index_we_are_choosing_for], the_list[random_choice_index] = \
                the_list[random_choice_index], the_list[index_we_are_choosing_for]


items = [1, 2, 5, 7, 2, 5, 0, 18, 29, 30]
shuffle(items)

print(items)
