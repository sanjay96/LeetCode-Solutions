class MedianFinder {
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue<>();
    boolean even = true;
    
    public MedianFinder() {

    }
    
    public void addNum(int num) {
        if (even) {
            max.offer(num);
            min.offer(max.poll());
        }
        else {
            min.offer(num);
            max.offer(min.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if (even)
            return (min.peek() + max.peek()) / 2.0;
        else
            return min.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */