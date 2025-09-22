# H04E02 - Mock Object Pattern

This project is a solution to the "Mock Object Pattern" exercise for the **INHN0006 Introduction to Software Engineering** course by Prof. Dr. Stefan Wagner. The purpose of this exercise was to implement unit tests for a system model using the **Mock Object Pattern** and the **EasyMock** framework. This approach allows for testing the `Discussion` class (System Under Test) independently from its collaborating objects, such as `Comment` and `Course`, which were not yet fully implemented.

---

## Solution Overview

The solution consists of three unit tests implemented within the `DiscussionTest` class, all following the Mock Object Pattern. The tests were designed to verify the functionality of the `Discussion` class as described by the following UML class diagram.



---

## Implemented Tasks

The solution addresses three key tasks, all implemented within the `DiscussionTest` class.

### 1. Set up the `DiscussionTest` class
The `DiscussionTest` class was prepared by adding a new attribute `discussion` as the test subject (SUT). Additionally, two mock attributes, `courseMock` of type `Course` and `commentMock` of type `Comment`, were added to represent the collaborating objects.

### 2. Test `addComment()` method
A test method named `testComment()` was implemented to verify the `addComment()` functionality. The test mocks the `save()` method of the `Comment` object to always return `true`, simulating a successful save. The test then verifies that `addComment()` returns the correct value and that `getNumberOfComments()` is incremented correctly.

### 3. Write another test for `addComment()`
A second test, `testCommentIfSavingFails()`, was created to handle a failure scenario. This test verifies that if the mocked `save()` method returns `false`, the `addComment()` method also returns the correct value, and the number of comments does not increase.

### 4. Test `startCourseDiscussion()`
A test method named `testStartCourseDiscussion()` was implemented to test the `startCourseDiscussion()` method. The test mocks the `isDiscussionAllowed()` method of the `Course` to allow a `Person` to start a discussion. It then verifies that `startCourseDiscussion()` returns the correct value and properly sets the course and topic of the `Discussion` object.
