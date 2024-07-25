function binarySearch(arr, target) {
    let left = 0;
    let right = arr.length - 1;

    while (left <= right) {
        const mid = Math.floor((left + right) / 2);

        // if (arr[mid] === target && (mid === left || target != arr[mid - 1])) {
        if (arr[mid] === target) {
            return mid; // target found at index mid
        } else if (arr[mid] < target) {
            left = mid + 1; // search in the right half
        } else {
            right = mid - 1; // search in the left half
        }
    }

    return -1; // target not found
}

const readline = require('readline');

const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

let input = [];
rl.on('line', (line) => {
	if (line.trim() === '0') {
		rl.close();
	} else {
		input.push(line);
	}
});

rl.on('close', () => {
	solveProblem(input);
});

function solveProblem(inp) {
    let line = 0;
    let i = 0;
    let countCase = parseInt(inp[line]);
    while(i < countCase) {
        line += 1;
        const nq = inp[line].split(' ').map(item => parseInt(item));
        const N = parseInt(nq[0])
        const Q = parseInt(nq[1])
        line += 1;
        let arrs = inp[line].split(' ').map(item => parseInt(item));
        arrs = arrs.sort((a,b) => a - b);
        const result = {};
        for (let i = 0; i < arrs.length; i += 1) {
            const target = Q - arrs[i]
            if (arrs.length === 1) {
                if (target === 0 || target === arrs[i]) continue;
            }

            if (result[`${arrs[i]}`] == undefined && result[`${target}`] == undefined) {
                const pos = binarySearch(arrs, target)
                if (pos >= 0) {
                    result[`${arrs[i]}`] = true;
                    result[`${target}`] = true
                }
            }
        }
        console.log(Object.keys(result).length / 2)
        i += 1;
    }
}