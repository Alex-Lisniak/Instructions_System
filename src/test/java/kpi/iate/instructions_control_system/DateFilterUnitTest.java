package kpi.iate.instructions_control_system;


import kpi.iate.instructions_control_system.dto.InstructionsDto;
import kpi.iate.instructions_control_system.filters.DateFilterImpl;
import kpi.iate.instructions_control_system.parser.StringToDateLongParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class DateFilterUnitTest {

    @InjectMocks
    private DateFilterImpl filter;

    @Spy
    private StringToDateLongParser parser;

    private InstructionsDto instructionsDtoFirst;
    private InstructionsDto instructionsDtoSecond;
    private InstructionsDto instructionsDtoThird;

    private Date dateFirst = new Date(110, 10, 19, 10, 10);
    private Date dateSecond = new Date(111, 10, 19, 10, 10);
    private Date dateThird = new Date(112, 10, 19, 10, 10);


    @BeforeEach
    public void setup() {
         instructionsDtoFirst = new InstructionsDto();
         instructionsDtoSecond = new InstructionsDto();
         instructionsDtoThird = new InstructionsDto();

        instructionsDtoFirst.setExpTime(dateFirst);
        instructionsDtoSecond.setExpTime(dateSecond);
        instructionsDtoThird.setExpTime(dateThird);

        instructionsDtoFirst.setStartTime(dateFirst);
        instructionsDtoSecond.setStartTime(dateSecond);
        instructionsDtoThird.setStartTime(dateThird);

        instructionsDtoSecond.setTitle("should be first");
        instructionsDtoFirst.setTitle("should be second");
        instructionsDtoThird.setTitle("should be third");
    }

    @Test
    public void filterByExpDateFullListTest() {
        List<InstructionsDto> list;
        list = new ArrayList<>();
        list.add(instructionsDtoSecond);
        list.add(instructionsDtoThird);
        list.add(instructionsDtoFirst);

        List <InstructionsDto> actualList = filter.filterInstructionsByExpDate("20.10.2031", list);

        assertTrue(actualList.size() == list.size());
    }

    @Test
    public void filterByExpDateEmptyListTest() {
        List<InstructionsDto> list;
        list = new ArrayList<>();
        list.add(instructionsDtoSecond);
        list.add(instructionsDtoThird);
        list.add(instructionsDtoFirst);

        List <InstructionsDto> actualList = filter.filterInstructionsByExpDate("20.10.1999", list);

        assertTrue(actualList.size() == 0);
    }

    @Test
    public void filterInstructionsByStartDateFullListTest() {

        List<InstructionsDto> list;
        list = new ArrayList<>();
        list.add(instructionsDtoSecond);
        list.add(instructionsDtoThird);
        list.add(instructionsDtoFirst);

        List <InstructionsDto> actualList = filter.filterInstructionsByStartDate("20.10.1999", list);

        assertTrue(actualList.size() == list.size());
    }
    @Test
    public void filterInstructionsByStartDateEmptyListTest() {
        List<InstructionsDto> list;
        list = new ArrayList<>();
        list.add(instructionsDtoSecond);
        list.add(instructionsDtoThird);
        list.add(instructionsDtoFirst);

        List <InstructionsDto> actualList = filter.filterInstructionsByStartDate("20.10.4174", list);

        assertTrue(actualList.size() == 0);
    }
}
