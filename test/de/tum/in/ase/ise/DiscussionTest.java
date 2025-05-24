package de.tum.in.ase.ise;

import org.easymock.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(EasyMockExtension.class)
class DiscussionTest {

    // TODO: Implement the tests
    @TestSubject
    private Discussion discussion;
    @Mock
    private Course courseMock;
    @Mock
    private Comment commentMock;
}
