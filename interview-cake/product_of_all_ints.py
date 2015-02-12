'''
You have an array of integers, and for each index you want to find the product of every integer except the integer at that index.
Write a function get_products_of_all_ints_except_at_index() that takes an array of integers and returns an array of the products.

For example, given:
  [1, 7, 3, 4]
your function would return:
  [84, 12, 28, 21]
by calculating:
  [7*3*4, 1*3*4, 1*7*4, 1*7*3]

'''
__author__ = 'girish'


def get_products_of_all_ints_except_at_index(inputArray):
    products = [1] * len(inputArray)

    if len(inputArray) == 1:
        return products

    product_so_far = 1
    for i in xrange(len(inputArray)):
        products[i] = product_so_far
        product_so_far = product_so_far * inputArray[i]

    product_so_far = 1
    i = len(inputArray) - 1
    while i >= 0:
        products[i] = product_so_far * products[i]
        product_so_far = product_so_far * inputArray[i]
        i -= 1

    return products

if __name__ == '__main__':
    inputArray = [1, 7, 3, 4]
    print get_products_of_all_ints_except_at_index(inputArray)