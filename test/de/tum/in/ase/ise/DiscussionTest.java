package de.tum.in.ase.ise;

import org.easymock.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
class DiscussionTest {

    // TODO: Implement the tests
    @TestSubject
    private Discussion discussion;
    @Mock
    private Course courseMock;
    @Mock
    private Comment commentMock;

    @BeforeEach
    void setUp() {
        discussion = new Discussion();
        commentMock = EasyMock.createMock(Comment.class);
        courseMock = EasyMock.createMock(Course.class);
    }

    @Test
    void testComment() {
        expect(commentMock.save()).andReturn(true);
        replay(commentMock);

        int before = discussion.getNumberOfComments();
        boolean added = discussion.addComment(commentMock);

        assertTrue(added);
        assertEquals(before + 1, discussion.getNumberOfComments());

        EasyMock.verify(commentMock);
    }

    @Test
    void testCommentIfSavingFails() {
        expect(commentMock.save()).andReturn(false);
        replay(commentMock);

        int before = discussion.getNumberOfComments();
        boolean added = discussion.addComment(commentMock);

        assertFalse(added);
        assertEquals(before, discussion.getNumberOfComments());

        EasyMock.verify(commentMock);
    }

    @Test
    void testStartCourseDiscussion() {
            String topic = "Agile Development";
            LocalDate birthDate = LocalDate.of(2006, 5, 10);
            Person student = new Student("Ebrahim", "Udaipurwala", birthDate, "BIE", "CS");

            EasyMock.expect(courseMock.isDiscussionAllowed(student)).andReturn(true);
            EasyMock.replay(courseMock);

            boolean started = discussion.startCourseDiscussion(courseMock, student, topic);

            assertTrue(started);
            assertEquals(courseMock, discussion.getCourse());
            assertEquals(topic, discussion.getTopic());

            EasyMock.verify(courseMock);
    }
}
