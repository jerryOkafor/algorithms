import Foundation

//check for Naiv two sum implementation in Kotlin folder

func twoSum(array:[Int], target:Int) -> (Int,Int)?{
    var numberMap = [Int:Int]()
    
    for (i,num) in array.enumerated(){
        let complement = target - num
        
        if numberMap.contains(where: {$0.key == complement}){
            return (numberMap[complement]!,i)
        }else{
            numberMap[num] = i
        }
    }
    return nil
}

if let indices = twoSum(array: [2, 7, 11, 15], target: 9){
    print(indices)
}

