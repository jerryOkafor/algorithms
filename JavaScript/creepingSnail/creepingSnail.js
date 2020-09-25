/* 
Snail creeps up the vertical pole of height H feet. It goes A feet up per day, 
and B feet down per night. In which day the snail will reach the top of the pole?

Input data format
On the input the program receives non-negative integers H, A, B, where H > B and A > B. Every integer does not exceed 100.

Sample Input 1:
10
3
2
Sample Output 1:
8

Sample Input 2:
20
7
3
Sample Output 2:
5
*/

const findDays = (height, up, down) => {
    //ensure that down != up else we will end up in an endless loop
    if (up === down) {
        throw new Error('Invalid params')
    }
    let runninHeight = 0
    let days = 0

    while (true) {
        days++
        runninHeight += up

        if (runninHeight >= height) {
            break
        }

        runninHeight -= down
    }

    return days
}

module.exports = findDays


//console.log(findDays(10, 3, 2))