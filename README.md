CSCI-598 Program Verification & Synthesis, Spring 2020
======================================================

## Course Information

- Lecture Time/Location: Tue Thu 11:00am-12:15am, Alderson Hall 152

## Instructor

[Jedidiah McClurg](https://www.jrmcclurg.com/), Assistant Professor of CS

- Contact: mcclurg (at) mines (dot) edu
- Office: Brown Hall 280C
- Office Hours: Tue 3:00pm-3:50pm, Thu 2:00pm-3:50pm

## Teaching Assistant (TA)

(No teaching assistant)

## Course Overview

This course is a hands-on introduction to formal methods. Students will learn how to (1) reason about correctness of programs using first-order logic, temporal logic, and Hoare logic, (2) build tools such as model-checkers to formally verify (exhaustively test) programs written in various languages, and (3) leverage verification functionality to automatically generate (synthesize) correct programs from high-level descriptions of program behavior.

## Prerequisites

There are no official prerequisites, but it is recommended that you
have some familiarity with the material covered in
[CSCI-400 Programming Languages](https://mines-csci400.github.io/f19-syllabus/).

## Course Goals

1. Learn several approaches for specifying and reasoning about correctness of programs.
2. Learn how to build *verification tools* to check the correctness of programs.
3. Gain exposure to recent research in the area of *program synthesis*.
4. Apply some verification/synthesis techniques in a domain of interest to you.

## IMPORTANT CAVEATS

1. **A purely grade-driven approach to taking (graduate) courses is
   at best unnecessary, and at worst highly counterproductive.**
   The volume of grade-related email/questions generated by students at Mines
   (and elsewhere) is far too high. As a (graduate) student, your task is
   not to to squeeze every possible point out of the course, your job is to
   learn the material, and be able to use it in the real world (for your
   research, or for your future job, etc.). It's likely that 99% of
   employers are NOT going to care if you have an A versus an A- or B+,
   but they ARE going to care if you can reason about computer science
   concepts, write code, and understand how to build systems.

2. **YOU will determine how much knowledge/experience you gain from this
   course.** The instructor has lots of expertise in the domains covered
   in the course, and will work hard to present you with the resources,
   tools, and techniques to develop a similar skillset. However, education
   is not a pre-packaged box that the instructor can hand out -- YOU
   will need to put in the effort to actively engage with the material,
   participate in class, and work hard on the assignments/projects.

3. **We will take a very formal approach to the topics**, i.e., we will
   carefully develop the mathematical/logical underpinnings of the concepts
   examined throughout the course. Although this may seem dry or boring at
   first, it is very important for you to develop a taste for *being rigorous*
   about computer science. This type of approach will suit you well in your
   future career, regardless of your research area or future career plans.
 
4. **We will learn how to read and absorb highly technical written materials**. 
   Throughout the course, the instructor will work to collect some of the most
   easily-digestible materials for your reference, but a big part of research
   is figuring out things that you don't quite understand at first glance.
   You will need to exercise perseverance in reading research papers, and
   iterate until the pieces start falling into place.

## Online Community and Communication

**In Homework 1, you will be asked to introduce yourself to the instructor. This includes sending
a passport-style photo of yourself to the instructor (or adding one on your Canvas profile).
The photo must be clear, with your face un-obstructed.**
If you are not comfortable providing a photo, then you will need to contact the instructor to set up
a brief in-person meeting to introduce yourself.
Failure to meet this requirement on Homework 1 will result in a 0 (zero) for the Participation component
of the grade.

We will use [Piazza](https://piazza.com/) in the class.
This is a great way to ask questions and communicate with the instructor
and your classmates. Participation on Piazza
will factor into the Participation component of the grade.

The class Piazza link is:
[https://piazza.com/class/k51i3nb2iw64cp](https://piazza.com/class/k51i3nb2iw64cp)

The instructor will use Piazza to communicate with the class. If you have
questions about the course, you should first do a quick search on the Piazza
page, to make sure your question has not already been answered there. If not,
please go ahead and post your question on Piazza so that the instructor or
another student can answer it publicly. This will help to streamline the
communication.

NOTE: if you have a question you do not wish to publicize (e.g., about
grades, etc.), please create a "private post" on Piazza. **Email should only
be used in rare instances where use of Piazza would not be feasible.**

There is a Github organization for the class:
[https://github.com/mines-pvs](https://github.com/mines-pvs)

All of your individual/team repositories will show up there.

## Textbook and Other Reading Materials

NOTE: the following resources are *recommended*, but not required. I will
assign readings from these sources to supplement our discussions in class,
but our in-class discussions will constitute the "official" version of
the course material.

- [*Logic in Computer Science* by Huth and Ryan](https://piazza.com/class_profile/get_resource/k51i3nb2iw64cp/k51mek3j9ck2fy)

The above links will take you to free versions of the materials.

## Class Notes

Class notes will be posted 1-2 days after the lecture.
**Posted notes are not guaranteed to provide all information discussed in lecture**
(class attendance is highly recommended).

## Grading

The following percentages show how final grades will be calculated.
I will *not* perform any rounding on the scores (e.g., a score of
92.999 will not be rounded up to 93).
I may or may not curve the overall
grades, depending on how well the class performs overall, however,
*I expect each student to
work hard, and not rely on the curve!* 

| item             | percentage    |
| -----------------|---------------|
| homeworks        | 40%           |
| midterm exam     | 15%           |
| presentations    | 15%           |
| final project    | 20%           |
| participation    | 10%           |

Letter grades will be calculated based on the following intervals:

| range    | grade |
|----------|--------------|
| [93,100] | A |
| [90,93)  | A- |
| [87,90)  | B+ |
| [83,87)  | B |
| [80,83)  | B- |
| [77,80)  | C+ |
| [73,77)  | C |
| [70,73)  | C- |
| [67,70)  | D+ |
| [63,67)  | D |
| [60,63)  | D- |
| [0,60)   | F            |

## Late Policy

Any work submitted after midnight (Mountain Time) on the stated deadline
will be subject to a *late penalty*. If the work is submitted *x* hours
late, the following percentage will be deducted from your score:

[1.13 / (1 + e^(-2 × 0.51 × ((x / 24) - 2))) - 0.13](https://www.wolframalpha.com/input/?i=plot+%5B1.13+%2F+%281+%2B+e%5E%28-2*0.51*%28%28x%2F24%29-2%29%29%29+-+0.13%5D+from+0+to+%287*24%29).

Notice that the penalty increases as times passes: 24 hours late is -17%, 48 hours late is -44%, 72 hours late is -70%, etc.

## Attendance

We will not take attendance, but your overall
class attendance will factor into the Participation component of the grade.

## Collaboration

We will use GitHub for collaboration. We will use private individual and team-specific
repositories to submit assignments. Your repositories will show up here:
[https://github.com/mines-pvs](https://github.com/mines-pvs)

## Respectfulness and Academic Honesty

Every student is expected to show respect to the instructors and the rest of the class. This course is preparation
for your future career, so make sure you are behaving with the same level of professionalism that
would be expected at a future full-time position. The general rule of thumb is:
**_informal_ is okay, but _disrespectful_ is not**.

- The instructor prefers to be addressed by his nickname "Jed", but "Prof. McClurg" or "Dr. McClurg" is also fine.
- It is vital that you do your best to be participate in the class, and communicate with the instructor(s) about any course-related difficulties you are facing.

Plagiarism/cheating is NOT acceptable, and will be met with the maximum available penalty.
Sophisticated plagiarism-detection software will be used on every submitted assignment, and
all confirmed instances of cheating will be immediately reported to the Computer Science department.
Please ensure that you do not engage in or facilitate academic dishonesty in this class!

## Course Feedback

Just as you expect the instructor to grade your coursework in a fair and
timely fashion, the instructor expects you to take the Mines course
feedback seriously. Feedback is typically collected during the *two weeks
before finals week*.

As an encouragement to participate in the course feedback, the instructor will
monitor the overall response rate via Canvas -- if the overall response rate
goes above 50%, *all* students in the class will receive bonus points
worth 50% of a homework assignment.

Your feedback is important! I will read all of your comments, and use them to help improve my course/teaching in the future. Rather than simply leaving a numeric rating, please describe your rating in words -- for example, a high score without any indication of what you enjoyed/gained from the class is great but not particularly informative, and a low score without any indication of what went wrong in the class will not help me improve.

Please put yourself in the instructor's shoes, and be **constructive** in
your comments.

## Accommodation

The Colorado School of Mines is committed to ensuring the full participation of all students in its programs, including students with disabilities. If you anticipate or experience any barriers to learning in this course, please feel welcome to discuss your concerns with me. Students with disabilities may also wish to contact Disability Support Services (DSS) to discuss options to removing barriers in this course, including how to register and request official accommodations. Please visit their website at [https://disabilities.mines.edu](https://disabilities.mines.edu) for contact and additional information.  If you have already been approved for accommodations through DSS, please meet with me at your earliest convenience so we can discuss your needs in this course.

## Schedule

This schedule is tentative, and is subject to change.

| week | date   | topic                                                                | lecture                                             | notes          | supplemental reading                                                                                                                                                                                                                                                              | homework                                                              | lab                                                                    |



- Logic Preliminaries: First-order logic, inductive definitions, proofs,
SAT solvers.
- Model checking: automata, temporal logic (LTL, CTL), binary decision
diagrams.
- Program Verification: Hoare logic, verification conditions, SMT solvers.
- Program Synthesis: counterexample-guided inductive synthesis (CEGIS),
syntax-guided synthesis (SyGuS), programming by example.

## Homework

There will be approximately 7 homeworks, which will be completed individually.
These are designed to help encourage you to keep up-to-date on the course material.
You will have approximately **2 weeks** to work on each homework.
