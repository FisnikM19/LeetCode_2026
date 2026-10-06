### 1.What is a `ListNode`?

Your class is:

```java
class ListNode {
    int val;
    ListNode next;
}
```

Each node contains two things:
```text
┌───────────┬───────────┐
│    val    │   next    │
├───────────┼───────────┤
│     7     │    ●──────┼──→ next node
└───────────┴───────────┘
```

For example:
```java
ListNode node1 = new ListNode(7);
```

creates:

```text
node1
  ↓
┌───────┬──────┐
│   7   │ null │
└───────┴──────┘
```

`next` is `null` because we haven't connected it to anything yet.

<hr>

### 2. How do we connect two nodes?

Suppose we create:

```java
ListNode node1 = new ListNode(7);
ListNode node2 = new ListNode(0);
```

Initially:
```text
node1                  node2
  ↓                      ↓
┌───────┬──────┐     ┌───────┬──────┐
│   7   │ null │     │   0   │ null │
└───────┴──────┘     └───────┴──────┘
```

Now:
```java
node1.next = node2;
```

This is the **connection**.

Now:
```text
node1
  ↓
┌───────┬───────┐
│   7   │   ●──────────┐
└───────┴───────┘      │
                       ↓
                  ┌───────┬──────┐
                  │   0   │ null │
                  └───────┴──────┘
```

So:
```text
node1.next
```

points to `node2`.

Therefore, we have:
```text
7 → 0 → null
```

That's a linked list.

<hr>

### 3. Now let's look at `dummy`

We start with:
```java
ListNode dummy = new ListNode();
ListNode current = dummy;
```

`new ListNode()` creates a node with the default value:
```text
dummy
  ↓
┌───────┬──────┐
│   0   │ null │
└───────┴──────┘
```

And then:
```java
current = dummy;
```

means both variables point to **the same node**:
```text
       ┌──────────────┐
       ↓              ↓
     dummy          current
       │              │
       └──────→ ┌─────┴─────┐
                │     0     │
                │   null    │
                └───────────┘
```

The important thing is:
> `dummy` and `current` are references pointing to the same node.

<hr>

### 4. First iteration

We calculate:
```text
2 + 5 = 7
```

Then:
```java
current.next = new ListNode(7);
```

Remember, `current` currently points to the dummy node.

So we're doing:
```text
dummy/current
     ↓
┌────────┬──────┐
│   0    │ null │
└────────┴──────┘
```

and:
```java
current.next = new ListNode(7);
```

connects a new node:
```text
dummy/current
     ↓
┌────────┬─────────┐
│   0    │    ●──────────→ ┌──────┬──────┐
└────────┴─────────┘        │  7   │ null │
                            └──────┴──────┘
```

Now we execute:
```java
current = current.next;
```

So `current` moves to the new `7` node:
```text
dummy
  ↓
┌──────┬─────────┐
│  0   │    ●────────→ ┌──────┬──────┐
└──────┴─────────┘     │  7   │ null │
                       └──────┴──────┘
                              ↑
                            current
```

Notice something very important:
> `dummy` **did NOT move**.

It still points to the first node.

<hr>

### 5. Second iteration

We calculate:
```text
4 + 6 = 10
```

So:
```text
value = 0
carry = 1
```

Now:
```java
current.next = new ListNode(0);
```

`current` is pointing to `7`.

Therefore:
```text
dummy
  ↓
┌──────┬───────┐
│  0   │   ●────────→ ┌──────┬───────┐
└──────┴───────┘      │  7   │   ●────────→ ┌──────┬──────┐
                      └──────┴───────┘       │  0   │ null │
                                             └──────┴──────┘
```

Then:
```java
current = current.next;
```

Now `current` points to the `0`:
```text
dummy
  ↓
  0 → 7 → 0
           ↑
         current
```

<hr>

We calculate:
```text
3 + 4 + 1 = 8
```

Then:
```java
current.next = new ListNode(8);
```

So:
```text
dummy
  ↓
  0 → 7 → 0 → 8 → null
                 ↑
               current
```

The dummy node is still at the beginning.

<hr>

### 7. So why does dummy.next give us the entire list?

This is the beautiful part.

Our list currently looks like:

```text
dummy
  ↓
  0 → 7 → 0 → 8 → null
```

The `0` at the beginning is just the dummy node.

We **don't want to return it**.

So:
```java
return dummy.next;
```

means:
> Give me the node immediately after the dummy.

That node is the first real result node:
```text
dummy
  ↓
  0 → 7 → 0 → 8 → null
      ↑
   dummy.next
```