def get_permutation(string):
    """
    Write arecursive function for genrating all permutations of an input
    String. Return them as a set.

    Solutions:

    Using a base case and breaking the problem into the smallest possible case -> a char say s

    Given s -> s

    Second possible case is st -> (s) -> (t) <- (s)
    Simply hold t and add s before and after s.

    Similarly, given cat, we can find all permutations of cats as follows:
    Permutations of cat:
        cat
        cta
        atc
        act
        tac
        tca
    For each permutation, we insert s accordingly from index 0..length:
      cat
        scat
        csat
        cast
        cats

      cta
        scta
        csta
        ctsa
        ctas
    """
    # Base case
    if (len(string) == 1):
        return set([string])

    all_chars_except_last = string[:-1]
    last_char = string[-1]

    # Use recursive call to get all possible permutations for all chars except the last
    permutation_of_all_chars_except_last = get_permutation(all_chars_except_last)

    # Insert the last char to all possible positions for each of the above permutations
    permutations = set()

    for p_all_chars_except_last in permutation_of_all_chars_except_last:
        for position in range(len(all_chars_except_last) + 1):
            permutation = p_all_chars_except_last[:position] + last_char + p_all_chars_except_last[position:]
            permutations.add(permutation)

    return permutations


print(get_permutation("cats"))
