#1
print "Hello World!"

#2
name = "sigurd"
'''raw_input("what is your name?\n")'''
print "Hello, %s" % (name)

#3
if name.lower() == "sigurd" or name.lower() == "felix":
    print "access granted"
else:
    print "access denied"

#4
n = int(raw_input('n = '))

'''for x in range(0, n):
    if x % 3 == 0 or x % 5 == 0:
        print x'''

#5
option = raw_input("'a' for addition, 'm' for multiplication\n")

if option == "a":
    result = 0
    for x in range(0, n):
        result += x
    print result

elif option.lower() == "m":
    result = 1
    for x in range(1, n+1):
        result = result * x
    print result
else:
    print "unknown option"
