//: [Previous](@previous)
/*:
 #  Majority Element
 
 Given an array of size n, find the majority element.
 The majority element is the element that appears more than ⌊ n/2 ⌋times.
 You may assume that the array is non-empty and the majority element always exist in the array.
 
 ## Example 1:
 Input: [3,2,3] => Output: 3
 
 ## Example 2:
 Input: [2,2,1,1,1,2,2] => Output: 2
 
 */
//: [Next](@next)

func majorityElement(_ numbers:[Int]) -> Int{
    var runningMajorityElementIndex = 0
    var count = 1 //sttarting by taking the first element as a majority element
    
    //Find total number of all posible majority elements by looping
    //through [numbers] and maintaining a count of nums[majIndex].
    //if the next element is same then increment the count
    //if the next element is not same then decrement the count
    //if the count reaches 0 then changes the runningMajorityElementIndex to the index
    for i in 1..<numbers.count{
        if(numbers[runningMajorityElementIndex] == numbers[i]){
            count += 1
        }else{
            count -= 1
        }
        
        if count == 0{
            runningMajorityElementIndex = i
            count = 1
        }
    }
    
    var majorityCount = 0
    
    for i in 0..<numbers.count{
        if numbers[i] == numbers[runningMajorityElementIndex]{
            majorityCount += 1
        }
    }
    
    if majorityCount > numbers.count / 2{
        return numbers[majorityCount]
    }else{
        return -1
    }
    
}


measure(title: "Majority Element") {
    print(majorityElement([2,2,1,1,1,2,2]))
}
