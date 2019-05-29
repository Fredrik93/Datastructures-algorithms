
class Array2 {
    private final int max_elements = 200;
    private int size = 0;
    private int[] arr;
    public Array2(int n) {
        if ((n < 0) || (n > max_elements)) {
            throw new IllegalArgumentException("Array size must be non-negative");
        }
        arr = new int[max_elements];
        size = n;
    }
    /**
     *
     *  @return the size of the Array
     */
    public int size() {
        return size;
    }
    /**
     *  Set the i-th element to x We are not checking whether the index is
     in bounds,
     *  because dereferencing the array element does it for us.
     *
     *  @param i the index of the element
     *  @param x the element we're adding
     */
    public void set(int i, int x) {
        arr[i] = x;
    }
    /**
     *  Get the i-th element, Again, we are not checking if the index is in
     bounds.
     *
     *  @param i the index of the element to get
     *  @return the element found
     */
    public int get(int i) {
        return arr[i];
    }
    /**
     *
     *  @return the content of the array as a String
     */
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        if (size > 0) {
            res.append(arr[0]);
            for (int i = 1; i < size; ++i) {
                res.append(", ");
                res.append(arr[i]);
            }
        }
        res.append("}");
        return res.toString();
    }
    /**
     *  Hands on session 1 Exercise 1 - Insert element x at index i assuming
     i is max
     *  the size of the array.
     *
     *  @param i the index where to insert
     *  @param x the element to insert
     */
    public void insert(int i, int x) {
        if( i == this.size){
            set(i,x);
            size++;
        }
        else if ( size != max_elements ) {
            this.shift(i,x);
            size++;
        } else if ( i <= max_elements && i > size){
            throw new IndexOutOfBoundsException("index out of bounds, The array size is " + size() + ", and the index you inserted is " + i);
        }
        else {
            throw new IndexOutOfBoundsException("index out of bounds, make sure number is between 0 and 200");
        }

    }
    /**
     * Follows Hands on session 1 Exercise 1 (not originally in skeleton)
     * shifts all elements in the array with index equal or higher than i 1 index up and inserts x at index i
     *
     * @param i the index indicating shifting point
     * @param x the element to insert at i
     */
    public void shift(int i, int x) {
        for( int m = this.size -1 ; m >= i; m-- ) {
            arr[m+1] = arr[m];
        }
        arr[i] = x;
    }

    /**
     *  Hands on session 1 Exercise 2
     *
     *  @return true if the array is sorted
     */
    public boolean isSorted() {
        for ( int i = 0; i < size -1; i++){
            if ( arr[i] >= arr[i+1]){
                return false;
            }
        }
        return true;
    }
    /**
     *  Hands on session 1 Exercise 3
     *
     *  @return the length of longest increasing sub array
     */
    public int maxNonDecreasing() {
        if (isSorted()) {
            return size;
        }
        int maxLength = 1;
        int currentRecord = 1;
        for (int i = 0; i < size; i ++){
            if (i == size-1 ) {return maxLength;}
            if (arr[i]<=arr[i + 1]) {
                currentRecord++;
            } else {
                if (currentRecord > maxLength) {
                    maxLength = currentRecord;
                }
                currentRecord = 1;
            }
        }
        return maxLength;
    }
    /**
     *  Hands on session 1 Exercise 4 - returns the index of the first
     number in the
     *  first matching subarray
     *
     *  @param b The subarray to compare with
     *  @return the index where the subarray starts
     */
    public int subArrayIndex(Array2 b) {
        int bIndex = -1;
        int consecutiveMatch =0;
        for (int i = 0; i < this.size; i ++){
            if (arr[i] == b.get(0)){
                int k = i;
                for ( int j = 1;  j < b.size; j++){
                    if ( arr[k++] != b.get(j) ){
                        consecutiveMatch = j;
                        j = b.size();
                    }
                }
                if (consecutiveMatch == b.size -1){
                    bIndex = consecutiveMatch;
                    return bIndex;
                }
            }
        }
        return bIndex;
    }
    // Internal method for swapping
    private void swap( int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /**
     *  Hands on Session 3 Exercise 2 Return the maximum sum of all
     contiguous
     *  subarrays of the array.
     *
     *  @param array the array
     *  @param lo    the index of the low boundary of the subarray
     *  @param hi    the index of the high boundary of the subarray
     *  @return the sum of the subarray
     */
    public static int maxSubarraySum(int[] array, int lo, int hi) {
        throw new UnsupportedOperationException();
    }
    /**
     *  Assignment 1 Question 1 Reverse the array
     */
    public void reverse() {
        for(int i =0;i<size/2;i++){
            swap(i,size-i-1);

        }
        // see if thers is a solution for when you remove the last index and puts it in the first place and so on
    }
    /**
     *  Assignment 1 Question 2 Remove the element of index i from the
     array.
     *
     *  @param i the element to remove
     */
    public void remove(int i) {
        for (int j = i; j < size; j++) {
            arr[j] = arr[j + 1];
        }
        size--;
    }
    /**
     *  Assignment 1 Question 2 Remove the element of index i from the
     array. This
     *  method may change the order of the other elements of the array.
     *
     *  @param i the element to remove
     */
    public void remove2(int i) {
        arr[i]=arr[size-1];
        size--;

    }
    /**
     *  Assignment 1 Question 3 Return the index of the first occurrence of
     x in the
     *  array, or -1 if x does not occur.
     *
     *  @param x the element to find
     *  @return the index of the first occurrence
     */
    public int find(int x){
        for(int i=0;i<size;i++) {
            if (x == arr[i]) {

                return i;
            }
        }

       return -1;
    }
    /**
     *  Assignment 1 Question 4 Find the length of the longest palindrome
     that is a
     *  contiguous subsequence of the array.
     *
     *  @return The length of the palindrome
     */
    public int maxPalindrome() {
        int palindromeSize = 0;

        for (int i = 0; i < size; i++) {
            if (arr[i] == arr[i + 1]) {
                int k = 0;
                for (int j = i+1; j<size; j++){
                    if(arr[j] != arr[i-k]){
                        if (palindromeSize < ((j-1) - k)){
                            palindromeSize = (j-1) - k;
                            i = j;
                            j = size;
                        }
                    }
                    k = k+2;
                }
            }
        }
        return palindromeSize;

    }

    /**
     *  Assignment 2 Question 3 returns the sum of the largest contiguous
     ascending
     *  array
     *
     *  @return the sum
     */
    public int maxInterval() {
        throw new UnsupportedOperationException();
    }
    /**
     *  Assignment 2 Question 3 Return the median value of an array.
     *
     *  @return the median
     */
    public int median() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        Array2 a = new Array2(6);
        a.set(0, 2);
        a.set(1, 1);
        a.set(2, 9);
        a.set(3, 9);
        a.set(4, 1);
        a.set(5, 2);
        System.out.println(a.toString());


        System.out.println(a.maxPalindrome());





    }

    }


