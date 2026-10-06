# Longest Substring Without Repeating Characters

## Problem

Given a string `s`, find the length of the **longest substring without duplicate characters**.

A substring must contain **consecutive characters**.

For example:

```text
s = "abcabcbb"
```

The answer is `3`, because `"abc"`, `"bca"`, and `"cab"` are substrings without duplicate characters.

---

## My brute-force approach

The original solution checks every possible starting position and builds a substring until it finds a duplicate:

```java
public int lengthOfLongestSubstring(String s) {

    int maxLen = 0;

    for (int i = 0; i < s.length(); i++) {
        Set<Character> set = new HashSet<>();
        int count = 0;

        for (int j = i; j < s.length(); j++) {

            if (set.contains(s.charAt(j))) {
                break;
            }

            set.add(s.charAt(j));
            count++;
        }

        maxLen = Math.max(maxLen, count);
    }

    return maxLen;
}
```

This solution is correct, but it can take **O(n²)** time.

---

# Optimized Approach: Sliding Window

Instead of starting over whenever we find a duplicate, we keep a **window** of characters that currently contains no duplicates.

We use two pointers:

```java
int left = 0;
```

and:

```java
for (int right = 0; right < s.length(); right++)
```

The window is:

```text
[left ... right]
```

We store the characters currently inside the window in a `HashSet`.

The important idea is:

> When we find a duplicate, we don't throw away the entire window. We move `left` forward and remove characters until the duplicate disappears.

---

# Updated Code

```java
package p03_LongestSubstringWithoutRepeatingCharacters.optimized;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public int lengthOfLongestSubstring(String s) {

        int maxLen = 0;

        int left = 0;
        Set<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));   // 1
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));  // 3
        System.out.println(sol.lengthOfLongestSubstring("1R1T7"));    // 4
    }
}
```

---

# Example: `"1R1T7"`

Let's go through the algorithm step by step.

The string is:

```text
1 R 1 T 7
```

The indexes are:

```text
index:  0 1 2 3 4
        1 R 1 T 7
```

Initially:

```text
left = 0
set = {}
maxLen = 0
```

---

## Step 1: `right = 0`

Current character:

```text
1
```

The set does not contain `1`.

So:

```java
set.add('1');
```

Now:

```text
set = {1}
```

The current window is:

```text
1
```

Its length is:

```java
right - left + 1
```

which is:

```text
0 - 0 + 1 = 1
```

Therefore:

```text
maxLen = 1
```

Current state:

```text
left
 ↓
 1 R 1 T 7
 ↑
right

window = "1"
set = {1}
maxLen = 1
```

---

# Step 2: `right = 1`

Current character:

```text
R
```

Is `R` already in the set?

```java
set.contains('R')
```

No.

So we add it:

```java
set.add('R');
```

Now:

```text
set = {1, R}
```

The window is:

```text
1R
```

Its length is:

```text
right - left + 1
1 - 0 + 1 = 2
```

So:

```text
maxLen = 2
```

Current state:

```text
left
 ↓
 1 R 1 T 7
   ↑
 right

window = "1R"
set = {1, R}
maxLen = 2
```

---

# Step 3: `right = 2`

Current character:

```text
1
```

Now:

```java
set.contains('1')
```

is `true`.

We already have `1` inside our window.

Our current window is:

```text
1 R 1
↑     ↑
left  right
```

We cannot add the second `1` because that would create a duplicate.

So we enter:

```java
while (set.contains(s.charAt(right))) {
    set.remove(s.charAt(left));
    left++;
}
```

### First iteration of `while`

`left` is currently `0`.

Therefore:

```java
s.charAt(left)
```

is:

```text
1
```

Remove it:

```java
set.remove('1');
```

Now:

```text
set = {R}
```

Then:

```java
left++;
```

So:

```text
left = 1
```

Now our window is effectively:

```text
R 1
↑ ↑
L R
```

The duplicate `1` is gone.

The `while` condition is checked again:

```java
set.contains('1')
```

It is now `false`.

So we leave the `while` loop.

Then we add the current `1`:

```java
set.add('1');
```

Now:

```text
set = {R, 1}
```

The current window is:

```text
R1
```

Its length is:

```text
right - left + 1
2 - 1 + 1 = 2
```

So:

```text
maxLen = 2
```

Notice something important:

We **did not reset the whole set**.

The old approach would do something like:

```java
set = new HashSet<>();
```

But that would unnecessarily throw away `R`.

Instead, we only removed the characters from the left that were necessary.

---

# Step 4: `right = 3`

Current character:

```text
T
```

Is `T` already in the set?

```java
set.contains('T')
```

No.

So:

```java
set.add('T');
```

Now:

```text
set = {R, 1, T}
```

Our current window is:

```text
R1T
```

Its length is:

```text
right - left + 1
3 - 1 + 1 = 3
```

Therefore:

```text
maxLen = 3
```

Current state:

```text
    left
      ↓
 1 R 1 T 7
       ↑
      right

window = "R1T"
set = {R, 1, T}
maxLen = 3
```

---

# Step 5: `right = 4`

Current character:

```text
7
```

Is `7` already in the set?

```java
set.contains('7')
```

No.

Add it:

```java
set.add('7');
```

Now:

```text
set = {R, 1, T, 7}
```

The window is:

```text
R1T7
```

Its length is:

```text
right - left + 1
4 - 1 + 1 = 4
```

Therefore:

```text
maxLen = 4
```

We have reached the end of the string.

The final answer is:

```text
4
```

The longest substring is:

```text
"R1T7"
```

---

# Complete Walkthrough

Here is the whole process in a simpler table:

| `right` | Character | `left` | Current window | Set | Window length | `maxLen` |
|---:|:---:|---:|:---:|:---|---:|---:|
| 0 | `1` | 0 | `"1"` | `{1}` | 1 | 1 |
| 1 | `R` | 0 | `"1R"` | `{1,R}` | 2 | 2 |
| 2 | `1` | 1 | `"R1"` | `{R,1}` | 2 | 2 |
| 3 | `T` | 1 | `"R1T"` | `{R,1,T}` | 3 | 3 |
| 4 | `7` | 1 | `"R1T7"` | `{R,1,T,7}` | 4 | 4 |

Therefore:

```text
Input:
"1R1T7"

Longest substring without duplicate characters:
"R1T7"

Length:
4
```

---

# Why the `while` loop is important

We use:

```java
while (set.contains(s.charAt(right))) {
    set.remove(s.charAt(left));
    left++;
}
```

instead of:

```java
if (set.contains(s.charAt(right))) {
    ...
}
```

because sometimes we need to remove **more than one character**.

For example:

```text
"abba"
```

When we reach the second `b`:

```text
a b b
↑   ↑
L   R
```

The duplicate is `b`.

We remove `a`:

```text
b b
↑ ↑
L R
```

But there is still a duplicate `b`.

Therefore we need to remove `b` as well:

```text
b
↑
L
```

Now the duplicate is gone.

That's why `while` is necessary.

---

# Why we calculate `right - left + 1`

Suppose:

```text
1 R 1 T 7
  ↑     ↑
 left  right
```

Here:

```text
left = 1
right = 4
```

The current window is:

```text
R 1 T 7
```

There are 4 characters.

The formula is:

```text
right - left + 1
```

Therefore:

```text
4 - 1 + 1 = 4
```

The `+1` is necessary because both `left` and `right` are included in the window.

---

# Why this is faster

The brute-force solution can take:

```text
O(n²)
```

time.

The sliding-window solution takes:

```text
O(n)
```

time.

Even though there is a `while` loop inside the `for` loop, `left` only moves forward.

For example:

```text
right:
0 → 1 → 2 → 3 → 4

left:
0 → 0 → 1 → 1 → 1
```

Neither pointer ever moves backward.

Each character can be:

- added to the set once
- removed from the set at most once

Therefore the overall time complexity is:

```text
Time:  O(n)
Space: O(n)
```

---

# The Main Idea to Remember

The most important thing to remember is:

> **Don't restart when you find a duplicate. Shrink the window from the left until the duplicate disappears.**

In code:

```java
while (set.contains(s.charAt(right))) {
    set.remove(s.charAt(left));
    left++;
}

set.add(s.charAt(right));

maxLen = Math.max(maxLen, right - left + 1);
```

Think of `left` and `right` as the two boundaries of a window:

```text
        left          right
          ↓             ↓
1 R 1 T 7
  └───────────────┘
      current window
```

`right` keeps expanding the window.

When a duplicate appears, `left` moves forward until the window becomes valid again.

For `"1R1T7"`:

```text
1
1R
R1      ← duplicate 1, move left
R1T
R1T7    ← longest valid substring
```

Final answer:

```text
4
```
