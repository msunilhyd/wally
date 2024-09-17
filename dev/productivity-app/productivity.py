'''
    devote 2 hrs per day to this algo trading process
    30 mins for research
    1.5 hours of backtest 1
    1.5 hours of backtest 2
    .5 hours reading a paper
    .5 hours watching youtube strategies
    .5 hours connecting with other traders
'''

import json
import time
from datetime import datetime, timedelta
from termcolor import cprint
import random

def load_tasks():
    with open('/Users/vn57558/linus/wally/dev/productivity-app/tasks.json', 'r') as f:
        tasks = json.load(f)
    return tasks

def get_tasks_schedule(tasks):
    task_start_time = datetime.now()
    schedule = []
    for task, minutes in tasks.items():
        end_time = task_start_time + timedelta(minutes=minutes)
        schedule.append((task, task_start_time, end_time))
        task_start_time = end_time
    return schedule

def main():
    tasks = load_tasks()
    schedule = get_tasks_schedule(tasks)
    current_index = 0

    while True:
        now = datetime.now()
        current_task, start_time, end_time = schedule[current_index]
        remaining_time = end_time - now
        remaining_minutes = int(remaining_time.total_seconds() // 60)

        print('')

        for index, (task, s_time, e_time) in enumerate(schedule):
            if index < current_index:
                # task is completed
                print(f'{task} done: {e_time.strftime("%H:%M")}')
            elif index == current_index:
                # current task
                if remaining_minutes < 2:
                    cprint('{task} < 2m left!', 'white', 'on_red', attrs=['blink'])
                elif remaining_minutes < 5:
                    cprint(f'{task} - {remaining_minutes} mins', 'white', 'on_red')
                else:
                    cprint(f'{task} - {remaining_minutes} mins', 'white', 'on_blue')
            else:
                print(f'{task} @ {s_time.strftime("%H:%M")}')

        list_of_reminders = [
            "i have a 1000 percent algo",
            "time is irrelevant, keep swimming",
            "every day i get better",
            "rest at the end",
            "jobs not finished",
            "deal was already made",
            "best algo trader in the world",
        ]

        random_reminder = random.choice(list_of_reminders)
        print(random_reminder)

        if now >= end_time:
            current_index += 1
            if current_index >= len(schedule):
                cprint("all tasks are completed", "white", "on_green")
                break

        time.sleep(15)
        print('Hello')
    print('Hey')

main()