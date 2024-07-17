def permute(nums):
    result = []
    # base case
    if len(nums) == 1:
        return [nums.copy()]

    for i in range(len(nums)):
        n = nums.pop(0)
        perms = permute(nums)

        for perm in perms:
            perm.append(n)
        result.extend(perms)
        nums.append(n)

    return result
print(permute([1]))
print(permute([1, 2, 3]))