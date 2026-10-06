## Optimized Approach — HashMap

The important idea is:

> Instead of searching through the rest of the array for the number we need, remember the numbers we've already seen.

Suppose we have:

```java
int[] nums = {2, 7, 11, 15};
int target = 9;
```

### Step 1 — Start with `i = 0`

```text
i = 0
nums[i] = 2
```

We need another number that, together with `2`, gives us the target `9`.

So we calculate:

```text
target - nums[i]
= 9 - 2
= 7
```

Now we ask:

> Have we already seen `7`?

**No.**

So we store the current number and its index:

```text
2 → index 0
```

---

### Step 2 — Move to `i = 1`

```text
i = 1
nums[i] = 7
```

Again, calculate the number we need:

```text
target - nums[i]
= 9 - 7
= 2
```

Now we ask:

> Have we already seen `2`?

**Yes!**

We stored it earlier:

```text
2 → index 0
```

The current number `7` is at index `1`.

Therefore, we have found the two numbers:

```text
2 + 7 = 9
```

Their indices are:

```text
0 and 1
```

So we return:

```java
return new int[]{0, 1};
```

### What the HashMap is doing

The `HashMap` stores:

```text
number → index
```

During the algorithm:

```text
i = 0
2 → 0

i = 1
7 → 1
```

When we encounter `7`, we calculate that we need `2`. Since `2` is already in the `HashMap`, we immediately know its index is `0`.

Therefore:

```text
[0, 1]
```

### Complexity

| Approach     |  Time | Space |
| ------------ | ----: | ----: |
| Nested loops | O(n²) |  O(1) |
| HashMap      |  O(n) |  O(n) |

The HashMap approach is faster because we don't have to search through the rest of the array every time. We can look up whether the required number has already appeared.
