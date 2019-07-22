define([ 'require', 'exports', 'log', 'util', 'message', 'comm', 'robot.controller', 'socket.controller', 'user.controller', 'user.model', 'guiState.controller',
'cookieDisclaimer.controller', 'program.controller', 'program.model', 'multSim.controller', 'progRun.controller', 'configuration.controller',
'import.controller', 'enjoyHint', 'tour.controller', 'simulation.simulation', 'progList.model', 'jquery', 'blocks', 'slick' ], function(require, exports, LOG,
UTIL, MSG, COMM, ROBOT_C, SOCKET_C, USER_C, USER, GUISTATE_C, CookieDisclaimer, PROGRAM_C, PROGRAM_M, MULT_SIM, RUN_C, CONFIGURATION_C, IMPORT_C,
EnjoyHint, TOUR_C, SIM, PROGLIST, $, Blockly) {
  function init() {
      initEvents();
  }
  exports.init = init;

  function initEvents() {
    var uri = window.location.toString();
    const params = new URLSearchParams(window.location.search);
    var choosenRobotType = params.get("robot");
    if (choosenRobotType) {
      ROBOT_C.switchRobot(choosenRobotType);
    }
  }
});
