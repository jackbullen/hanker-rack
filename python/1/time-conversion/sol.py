AMmap = {
    1: '01',
    2: '02',
    3: '03',
    4: '04',
    5: '05',
    6: '06',
    7: '07',
    8: '08',
    9: '09',
    10: '10',
    11: '11',
    12: '00'
}

def timeConversion(s):
    meridian = s[-2:]
    times = s[:-2].split(':')
    if meridian == "PM":
        if int(times[0]) != 12:
            times[0] = str(int(times[0]) + 12)
    else:
        times[0] = AMmap[int(times[0])]
    return ':'.join(times)