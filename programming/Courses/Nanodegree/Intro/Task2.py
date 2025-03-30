import csv
with open('texts.csv', 'r') as f:
    reader = csv.reader(f)
    texts = list(reader)

with open('calls.csv', 'r') as f:
    reader = csv.reader(f)
    calls = list(reader)


seconds = []
for second in [row[3] for row in calls] :
    seconds.append(int(second))
    
index = (seconds.index(max(seconds)))
max = calls[index]
print(max[0]+" spent the longest time, "+max[3]+" seconds, on the phone during September 2016")

