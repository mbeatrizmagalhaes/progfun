package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || c == r) 1
      else pascal(c-1, r-1) + pascal(c, r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def balanceIter(chars: List[Char], counter: Int): Boolean =
        if (chars.isEmpty) counter == 0
        else if (counter < 0) false
        else balanceIter(chars.tail, incrementCounter(counter, chars.head))

      def incrementCounter(currentCounter: Int, currentChar: Char) =
        if (currentChar.equals('(')) currentCounter + 1
        else if (currentChar.equals(')')) currentCounter - 1
        else currentCounter

      balanceIter(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0 || coins.isEmpty) 0
      else if (money < coins.head) countChange(money, coins.tail)
      else if (money == coins.head) 1 + countChange(money, coins.tail)
      else countChange(money, coins.tail) + countChange(money - coins.head, coins)
    }
  }
