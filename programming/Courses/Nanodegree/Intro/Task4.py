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

callers = [row[0] for row in calls]
recievers = [row[1] for row in calls]
textC = [row[0] for row in texts]
textR = [row[1] for row in texts]
telemarketers = []
for caller in callers :
    if caller not in recievers :
        if caller not in textC :
            if caller not in textR :
                telemarketers.append(caller)

    continue

print("These numbers could be telemarketers: ")
for telemarketer in sorted(telemarketers) :
    print(telemarketer)
"""
TASK 4:
The telephone company want to identify numbers that might be doing
telephone marketing. Create a set of possible telemarketers:
these are numbers that make outgoing calls but never send texts,
receive texts or receive incoming calls.

Print a message:
"These numbers could be telemarketers: "
<list of numbers>
The list of numbers should be print out one per line in lexicographic order with no duplicates.
"""

