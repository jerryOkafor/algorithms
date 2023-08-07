/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 05/08/2023
*/

package trees

import core.TreeNode
import utils.example


fun makeBeverageTree(): TreeNode<String> {
    val tree = TreeNode("Beverages")

    val hot = TreeNode("hot")
    val cold = TreeNode("cold")

    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val chocolate = TreeNode("cocoa")

    val blackTea = TreeNode("black")
    val greenTea = TreeNode("green")
    val chaiTea = TreeNode("chai")

    val soda = TreeNode("soda")
    val milk = TreeNode("milk")

    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")

    tree.add(hot)
    tree.add(cold)

    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)

    cold.add(soda)
    cold.add(milk)

    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)

    soda.add(gingerAle)
    soda.add(bitterLemon)

    return tree
}

fun main() {
    val tree = makeBeverageTree()

    "depth first traversal " example {
        tree.forEachDepthFirst { println(it.value) }
    }

    "Breath first traversal" example {
        tree.forEachLevelOrder { println(it.value) }
    }

    "search" example {
        tree.search("ginger ale")?.let {
            println("Found node: ${it.value}")
        }

        tree.search("WKD Blue")?.let {
            println(it.value)
        } ?: println("Couldn't find WKD Blue")
    }

    "print each level" example {
        tree.printEachLevel()
    }
}