# Problem-of-the-Week
# Find Minimum in Rotated Sorted Array

---

## **Approach and Logic**

### **Key Observations:**
1. The minimum element lies in the **unsorted part** of the array.
2. If `arr[mid] > arr[high]`, the minimum element must be to the **right** of `mid` because the left side is sorted and `mid` is not the smallest.
3. Otherwise, the minimum element lies to the **left** (including `mid` itself).

### **Steps:**
1. Initialize two pointers:  
   - `low = 0` (start of the array)  
   - `high = n - 1` (end of the array)
2. Perform binary search:
   - Find `mid = low + (high - low) / 2`
   - If `arr[mid] > arr[high]`, shift the search to the **right half** (`low = mid + 1`).
   - Otherwise, shift to the **left half** (`high = mid`).
3. Continue until `low == high`.
4. At the end of the loop, `arr[low]` is the **minimum element**.

---

## **Complexity Analysis**

### **Time Complexity:**  
- Each iteration of binary search reduces the search space by half.
- Total steps = **`O(log n)`** where `n` is the array size.

### **Space Complexity:**  
- We use only a few extra variables (`low`, `high`, `mid`), so **`O(1)`** auxiliary space.

---

