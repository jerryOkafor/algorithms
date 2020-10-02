//: [Previous](@previous)
/*:
 # 2 Sum
 Given an array of integers nums and an integer target, return indices of the two numbers
 such that they add up to target.You may assume that each input would have exactly one solution,
 and you may not use the same element twice.
 You can return the answer in any order.

 ## Example:
 Input: nums = [2,7,11,15], target = 9
 Output: [0,1]
 Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 
 *Check for Naive two sum implementation in Kotlin folder*
*/
//: [Next](@next)

import Foundation

//2 Sum implementation using Dictionary for lookup - Most efficient
//2 sum can also eb implemented with Brute force method with O(n^2)

//Time Complexity : O(n)
func twoSumEfficient(numbers:[Int], target:Int) -> (Int,Int)?{
   var numberMap = [Int:Int]()
      
      for (i,num) in numbers.enumerated(){
          let complement = target - num
          
          if numberMap.contains(where: {$0.key == complement}){
              return (numberMap[complement]!,i)
          }else{
              numberMap[num] = i
          }
      }
      return nil
}

//Works on sorted array of values
//Time Complexity: O(n*log(n))
func twoSumBy2Pointer(numbers:[Int], target:Int) -> (Int,Int)?{
    var left = 0
    var right = numbers.count - 1
    
    while(left < right){
        if numbers[left] + numbers[right] == target{
        return (left,right)
        }else if(numbers[left] + numbers[right] < target){
            //increase left
            left += 1
        }else{
            //decrease right
            right -= 1
        }
    }
    return nil
}




if let indices = twoSumEfficient(numbers: [2, 7, 11, 15], target: 9){
    print(indices)// => (0,1)
}


if let indices = twoSumBy2Pointer(numbers: [15, 2, 11, 7].sorted(), target: 9){
    print(indices)// => (0,1)
}





