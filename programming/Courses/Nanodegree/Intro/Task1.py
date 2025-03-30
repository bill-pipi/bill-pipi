"""
Read file into texts and calls.
It's ok if you don't understand how to read files.
"""
import csv
with open('texts.csv', 'r') as f:
    reader = csv.reader(f)
    texts = list(reader)

with open('calls.csv', 'r') as f:
    reader = csv.reader(f)
    calls = list(reader)

numbers = []
for n in [row[0] for row in calls] : numbers.append(n)
for n in [row[1] for row in calls] : numbers.append(n)
for n in [row[0] for row in texts] : numbers.append(n)
for n in [row[1] for row in texts] : numbers.append(n)
phones = len(set(numbers))
print("There are " + str(phones)  + " different telephone numbers in the records")

"""
TASK 1:
How many different telephone numbers are there in the records? 
Print a message:
"There are <count> different telephone numbers in the records."
"""
