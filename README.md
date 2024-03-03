# Project Management System
## Features

1. **User Management**: 
   - Users can be created using the `CREATE_USER` command, specifying email and password.
   
2. **Board Management**:
   - Boards can be created using the `CREATE_BOARD` command, indicating the user ID, board name, and visibility.
   - Users can be added to boards as members using the `ADD_BOARD_MEMBER` command.
   - Board members can be removed using the `REMOVE_BOARD_MEMBER` command.

3. **Column Management**:
   - Columns can be created within boards using the `CREATE_COLUMN` command, providing the board ID and column name.

4. **Card Management**:
   - Cards can be created within columns using the `CREATE_CARD` command, specifying the column ID and card title.
   - Cards can be moved between columns using the `MOVE_CARD` command.
   - Card details such as title and description can be updated using the `UPDATE_CARD` command.
   - Users can be added as members to cards using the `ADD_CARD_MEMBER` command.
   - Members can be removed from cards using the `REMOVE_CARD_MEMBER` command.
   - Comments can be added to cards using the `ADD_CARD_COMMENT` command.

## Usage

1. **Run the Application**:
   - Test the application by adding commands to the `sample_input/sample_input_one.txt` file.
   - Execute the `run.sh` script using `bash run.sh` in the terminal.

2. **Command Format**:
   - Each command should be written in the format `<COMMAND_NAME>,<PARAMETER1>,<PARAMETER2>,...`.
   - For example, to create a user, use `CREATE_USER,<EMAIL>,<PASSWORD>`.

3. **Input Commands**:
   - You can either test the application using commands from a file or directly input commands in the `inplace_commands` list within the code.

## Command List

- **CREATE_USER**: Create a new user.
- **CREATE_BOARD**: Create a new board.
- **ADD_BOARD_MEMBER**: Add a user as a member to a board.
- **REMOVE_BOARD_MEMBER**: Remove a member from a board.
- **CREATE_COLUMN**: Create a new column within a board.
- **CREATE_CARD**: Create a new card within a column.
- **MOVE_CARD**: Move a card to a different column.
- **UPDATE_CARD**: Update the title and description of a card.
- **ADD_CARD_MEMBER**: Add a user as a member to a card.
- **REMOVE_CARD_MEMBER**: Remove a member from a card.
- **ADD_CARD_COMMENT**: Add a comment to a card.

## Bonus Functionalities

The following functionalities are included as bonuses and are not part of the assessed features:

- **ADD_CARD_LABEL**: Add labels to cards.
- **ADD_CARD_CHECKLIST**: Add checklists to cards.
- **ADD_CARD_DUE_DATE**: Assign due dates to cards.
- **ARCHIVE_CARD**: Archive cards.
