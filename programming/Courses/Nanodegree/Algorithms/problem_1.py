def root(n, a, b, acc) :
    mid = (a+b)/2
    if acc == 0 : return mid
    if mid*mid > n : return root(n, a, mid, acc-1)
    return root(n, mid, b, acc-1)

def sqrt(n, acc) :
  if n < 0 : return str(root(n*-1, 0, n*-1, acc))+"i"
  return root(n, 0, n, acc)

print(sqrt(8, 20))
#2.8284263610839844
print(sqrt(False, 20))
#0.0
print(sqrt(-1, 100))
#1.0i
print(sqrt(1000000000, 996))
#31622.776601683792

